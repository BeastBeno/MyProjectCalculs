import xlrd
import numpy as np
import matplotlib.pyplot as plt
import pylab
import argparse

PARSER = argparse.ArgumentParser(
    description="Showing the graphs of the marks and the number of hours for the data sheet of a student")

PARSER.add_argument(
    'name', metavar='sheetName',
    nargs="+", help="Name of the data sheet")

PARSER.add_argument(
    '-m', "--marks", metavar="MARKS", dest='marks',
    help='shows the graph of the marks')

PARSER.add_argument(
    '-t', "--hours", metavar="HOURS", dest='hours',
    help="Student hours' graph")
PARSER.add_argument(
    '-b', "--best", metavar="BEST", dest='best',
    help="Best student hours' graph")

ARGS = PARSER.parse_args()
sheetName = ARGS.name
print(sheetName)


if ARGS.name is not None:
    document = xlrd.open_workbook("C:/Beno/Java/SessionOrganization/file/"+sheetName[0]+"_data.xlsx")
    feuille_1 = document.sheet_by_index(0)
    cols = feuille_1.ncols
    rows = feuille_1.nrows
    X = []
    Y = []
    Y2 = []

    if ARGS.marks is not None:
        for r in range(1, rows):
            X += [r]
            Y += [(feuille_1.cell_value(rowx=r, colx=1) * feuille_1.cell_value(rowx=r, colx=3)) / 100]  # Best marks I want
            Y2 += [(feuille_1.cell_value(rowx=r, colx=2) * feuille_1.cell_value(rowx=r, colx=3)) / 100]  # Marks that I got

        plt.plot(X, Y, "o-", label="Marks I want")
        plt.plot(X, Y2, "o-", label="Actual marks")
        plt.title("My session's marks")
        plt.xlabel("Evaluation number")
        plt.ylabel("Evaluation marks in percent %")
        plt.legend()
        plt.savefig(sheetName[0]+'MySession.png')
        plt.show()

    if ARGS.hours is not None:
        x = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15])
        y = np.array([3, 3, 3, 4, 6, 4, 4, 4, 4, 6, 4, 4, 4, 6, 6])

        # Calcul of difficulty degree
        difficulty = 0
        for i in range(len(Y)):
            difficulty += Y[i] - Y2[i]
        difficulty = (difficulty / (rows - 1))
        # creation of the new graph depends on the difficulties
        print(difficulty)
        y2 = []
        for i in range(0, len(y)):
            y2 += [y[i] + (difficulty * y[i]) / 100]

        width = 0.9
        BarName = ['week1', 'week2', 'week3', 'week4', 'week5', 'week6', 'week7', 'week8', 'week9',
                   'week10', 'week11', 'week12', 'week13', 'week14', 'week15']

        fig = plt.figure()
        plt.bar(x, y, width, color='#62FF33')
        plt.bar(x, y2, width, color='#EE6666')
        plt.title("My session works' hours")
        plt.xlabel("Week")
        plt.ylabel("Hours")
        pylab.xticks(x, BarName, rotation=40)
        plt.savefig('HoursBar.png')
        plt.show()

    if ARGS.best is not None:
        x = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15])
        y = np.array([3, 3, 3, 4, 6, 4, 4, 4, 4, 6, 4, 4, 4, 6, 6])
        width = 0.9
        BarName = ['week1', 'week2', 'week3', 'week4', 'week5', 'week6', 'week7', 'week8', 'week9',
                   'week10', 'week11', 'week12', 'week13', 'week14', 'week15']

        fig = plt.figure()
        plt.bar(x, y, width, color='#62FF33')
        plt.title("My session works' hours")
        plt.xlabel("Week")
        plt.ylabel("Hours")
        pylab.xticks(x, BarName, rotation=40)
        plt.savefig('HoursBar.png')
        plt.show()

