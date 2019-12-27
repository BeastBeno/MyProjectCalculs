import csv
import xlrd
import matplotlib.pyplot as plt


with open('C:/Users/awous/PycharmProjects/ProjectCalculs/data.csv', "r", encoding='utf-8-sig') as File:
    reader = csv.reader(File, delimiter=';')
    for line in reader:
        print(line)  # La tu auras chaque ligne

document = xlrd.open_workbook("C:/Users/awous/PycharmProjects/ProjectCalculs/data.xlsx")
print("Nombre de feuilles: "+str(document.nsheets))
print("Noms des feuilles: "+str(document.sheet_names()))

feuille_1 = document.sheet_by_index(0)

print("Format de la feuille 1:")
print("Nom: "+str(feuille_1.name))
print("Nombre de lignes: "+str(feuille_1.nrows))
print("Nombre de colonnes: "+str(feuille_1.ncols))

cols = feuille_1.ncols
rows = feuille_1.nrows

X = []
Y = []

for r in range(1, rows):
    X += [r]
    Y += [(feuille_1.cell_value(rowx=r, colx=1) *feuille_1.cell_value(rowx=r, colx=2)) /100]

plt.plot(X, Y)
plt.show()