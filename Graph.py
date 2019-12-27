import csv
import xlrd
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

