import datetime

class Course:
    def __init__(self, department, number, name, credits):
        self.department = department
        self.number = number
        self.name = name
        self.credits = credits

    def __str__(self): #EX: Algorithms, MPCS 55001, 3 credits
        return (self.name + ', ' + self.department + ' ' + str(self.number) + ' ('+ str(self.credits)+' credits)')
