import xlrd
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
from math import pi
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
cote = 0


if ARGS.name is not None:
    document = xlrd.open_workbook("../../res/image/"+sheetName[0]+"_data.xlsx")
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

        for e in Y2:
            cote += e
        print(cote)
        fig = plt.figure(figsize=(4, 3.2))
        #ax = plt.axes()
        # Setting the background color
        #ax.set_facecolor("grey")
        plt.style.use(['dark_background'])
        plt.style.use(['seaborn-bright'])
        #fig.patch.set_facecolor("grey")
        plt.plot(X, Y, "o-", label="Marks I want", color='green')
        plt.plot(X, Y2, "o-", label="Actual marks", color='blue')
        plt.title(sheetName[0]+" marks")
        plt.xlabel("Evaluation number")
        plt.ylabel("Evaluation marks in percent %")
        plt.legend()
        plt.savefig("../../res/image/"+sheetName[0]+'_MySession.png')
        #plt.show()

        #Performance graph
        fig = plt.figure(figsize=(10.5, 3))
        plt.plot(X, Y2, "o-", label="Personal performance")
        plt.title(sheetName[0]+" performance")
        plt.xlabel("Evaluation number")
        plt.ylabel("Evaluation marks in percent %")
        plt.legend()
        plt.savefig("../../res/image/"+sheetName[0]+'_MyPerformance.png')
        #plt.show()

        # Set data
        fig = plt.figure(figsize=(4, 3.2))
        df = pd.DataFrame({
            'group': ['A', 'B', 'C', 'D'],
            'Creative': [38, 1.5, 30, 4],
            'fast': [29, 10, 9, 34],
            'organize': [8, 39, 23, 24],
            'GPA': [7, 31, 33, 14],
            'upgrading': [28, 15, 32, 14]
        })

        # ------- PART 1: Create background
        #plt.style.use(['dark_background'])
        # number of variable
        categories = list(df)[1:]
        N = len(categories)

        # What will be the angle of each axis in the plot? (we divide the plot / number of variable)
        angles = [n / float(N) * 2 * pi for n in range(N)]
        angles += angles[:1]

        # Initialise the spider plot
        ax = plt.subplot(111, polar=True)

        # If you want the first axis to be on top:
        ax.set_theta_offset(pi / 2)
        ax.set_theta_direction(-1)

        # Draw one axe per variable + add labels labels yet
        plt.xticks(angles[:-1], categories)

        # Draw ylabels
        ax.set_rlabel_position(0)
        plt.yticks([10, 20, 30], ["10", "20", "30"], color="grey", size=7)
        plt.ylim(0, 40)

        # ------- PART 2: Add plots

        # Plot each individual = each line of the data
        # I don't do a loop, because plotting more than 3 groups makes the chart unreadable

        # Ind1
        values = df.loc[0].drop('group').values.flatten().tolist()
        values += values[:1]
        ax.plot(angles, values, linewidth=1, linestyle='solid', label="Me")
        ax.fill(angles, values, 'b', alpha=0.1)

        # Ind2
        values = df.loc[1].drop('group').values.flatten().tolist()
        values += values[:1]
        ax.plot(angles, values, linewidth=1, linestyle='solid', label="2nd part")
        ax.fill(angles, values, 'r', alpha=0.1)

        # Add legend
        plt.legend(loc='upper right', bbox_to_anchor=(0.1, 0.1))
        plt.savefig("../../res/image/" + sheetName[0] + '_MyAptitude.png')
        #plt.show()

    if ARGS.hours is not None:
        x = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15])
        y = np.array([3, 3, 3, 4, 6, 4, 4, 4, 4, 6, 4, 4, 4, 6, 6])

        for r in range(1, rows):
            X += [r]
            Y += [(feuille_1.cell_value(rowx=r, colx=1) * feuille_1.cell_value(rowx=r, colx=3)) / 100] #Best marks I want
            Y2 += [
                (feuille_1.cell_value(rowx=r, colx=2) * feuille_1.cell_value(rowx=r, colx=3)) / 100]  # Marks that I got
        # Calcul of difficulty degree
        difficulty = 0
        for i in range(len(Y)):
            difficulty += Y[i] - Y2[i]
        difficulty = (difficulty / (rows - 1))
        # creation of the new graph depends on the difficulties
        print(Y)
        print(difficulty)
        y2 = []
        for i in range(0, len(y)):
            y2 += [y[i] + (difficulty * y[i]) / 100]

        width = 0.9
        BarName = ['1', '2', '3', '4', '5', '6', '7', '8', '9',
                   '10', '11', '12', '13', '14', '15']

        fig = plt.figure(figsize=(4, 3.2))
        #ax = plt.axes()
        # Setting the background color
       # ax.set_facecolor("grey")
        #fig.patch.set_facecolor("grey")
        plt.style.use(['dark_background'])
        #338BFF(0.1, 0.1, 0.1, 0.1)
        plt.bar(x, y2, width, color=(0.1, 0.1, 0.1, 0.1), alpha=0.7, edgecolor='red')
        plt.grid(b=True, which='major', color='#666666', linestyle='-', alpha=0.3)
        plt.title(sheetName[0]+" hours")
        plt.xlabel("Week")
        plt.ylabel("Hours")
        pylab.xticks(x, BarName, rotation=40)
        plt.savefig("../../res/image/"+sheetName[0]+"_HoursBar")
        #plt.show()

    if ARGS.best is not None:
        x = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15])
        y = np.array([3, 3, 3, 4, 6, 4, 4, 4, 4, 6, 4, 4, 4, 6, 6])
        width = 0.9
        BarName = ['w1', 'w2', 'w3', 'w4', 'w5', 'w6', 'w7', 'w8', 'w9',
                   'w10', 'w11', 'w12', 'w13', 'w14', 'w15']

        fig = plt.figure(figsize=(3, 3))
        #ax = plt.axes()
        # Setting the background color
        #ax.set_facecolor("grey")
        #fig.patch.set_facecolor("grey")
        plt.style.use(['dark_background'])
        plt.bar(x, y, width, color='#62FF33')
        plt.title("My session works' hours")
        plt.xlabel("Week")
        plt.ylabel("Hours")
        pylab.xticks(x, BarName, rotation=40)
        plt.savefig("SessionOrganization/res/image/"+sheetName[0]+"_BestHoursBar.png")
        #plt.show()

