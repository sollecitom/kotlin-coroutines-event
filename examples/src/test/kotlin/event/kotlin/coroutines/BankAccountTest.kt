package event.kotlin.coroutines

import assertk.assertThat
import assertk.assertions.isEqualTo
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

class BankAccountTest {

    @Test
    fun increaseBalanceTest() = runTest { //runTest same as runBlocking but skips delays
        val testBankAccount = BankAccount()
        val expectedBalance = 110

        testBankAccount.increaseBalance(10)

        assertThat(testBankAccount.balance).isEqualTo(expectedBalance)
    }

    @Test
    fun increaseBalanceBlockingTest() = runBlocking {
        val testBankAccount = BankAccount()
        val expectedBalance = 110

        testBankAccount.increaseBalance(10)

        assertThat(testBankAccount.balance).isEqualTo(expectedBalance)
    }
}

class BankAccount {

    var balance : Int = 100

    suspend fun increaseBalance(amount : Int){
        delay(1000)
        balance += amount
    }

}