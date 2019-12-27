import csv
import xlrd
import numpy as np
import matplotlib.pyplot as plt



"""with open('C:/Users/awous/PycharmProjects/ProjectCalculs/data.csv', "r", encoding='utf-8-sig') as File:
    reader = csv.reader(File, delimiter=';')
    for line in reader:
        print(line)  # La tu auras chaque ligne
"""

document = xlrd.open_workbook("C:/Users/awous/PycharmProjects/ProjectCalculs/data.xlsx")
#print("Nombre de feuilles: "+str(document.nsheets))
#print("Noms des feuilles: "+str(document.sheet_names()))

feuille_1 = document.sheet_by_index(0)

#print("Format de la feuille 1:")
#print("Nom: "+str(feuille_1.name))
#print("Nombre de lignes: "+str(feuille_1.nrows))
#print("Nombre de colonnes: "+str(feuille_1.ncols))

cols = feuille_1.ncols
rows = feuille_1.nrows

X = []
Y = []
Y2 = []

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
plt.show()

x = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15])
y = np.array([3, 3, 3, 4, 6, 4, 4, 4, 4, 6, 4, 4, 4, 6, 6])

# Calcul of difficulty degree
difficulty = 0
for i in range(len(Y)):
    difficulty += Y[i] - Y2[i]
difficulty = (difficulty / (rows-1))
# creation of the new graph depends on the difficulties
print(difficulty)
y2 = []
for i in range(0, len(y)):
    y2 += [y[i] + (difficulty * y[i])/100]
    print(y2[i])

plt.plot(x, y, "*:", label="Session's week")
plt.plot(x, y2, "o-", label="New week")
plt.title("My session works' hours")
plt.xlabel("Week")
plt.ylabel("Hours")
plt.legend()
plt.show()

