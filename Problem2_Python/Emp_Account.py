class Emp_Account:
    def __init__(self, emp_id, emp_name, emp_acct_balance):
        self.EmpId = emp_id
        self.EmpName = emp_name
        self.EmpAcctBalance = emp_acct_balance

    def creditAmount(self, amount):
        self.EmpAcctBalance += amount
        print(f"Credited Amount: {amount}")
        print(f"Updated Balance: {self.EmpAcctBalance}")

    def debitAmount(self, amount):
        if amount <= self.EmpAcctBalance:
            self.EmpAcctBalance -= amount
            print(f"Debited Amount: {amount}")
        else:
            print(f"The Requested debit amount {amount} is more than the current balance amount {self.EmpAcctBalance}, hence this operation cannot be done - Sorry :)")
        print(f"Updated Balance: {self.EmpAcctBalance}")

    def printBalance(self):
        print(f"Final Balance for {self.EmpName} (ID: {self.EmpId}): {self.EmpAcctBalance}")

emp_account = Emp_Account(9, "Manojkumar Ammasai Kutti", 45000)

emp_account.creditAmount(6000)

emp_account.debitAmount(10000)

emp_account.printBalance()
