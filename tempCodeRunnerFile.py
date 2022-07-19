import os
from re import RegexFlag
import shutil

source_base_folder = r"/Users/nirajramakantchaudhari/Documents/Programs/PractisedCodingProblems/"
destination_base_folder = r"/Users/nirajramakantchaudhari/Documents/Programs/PractiseDataStructures/"

filesCount = 1


def countFiles():
    global filesCount

    # fetch all folders
    for folder in os.listdir(source_base_folder):
        source_folder = source_base_folder+folder

        if(os.path.isdir(source_folder)):
            # fetch all files in the given folder
            for file_name in os.listdir(source_folder):
                filesCount = filesCount+1

    print("Count of Total Files is : ", filesCount)


def solution(s):
    return ''.join(' ' + c if c.isupper() else c for c in s)


def makeCommits():
    global filesCount

    # countFiles()

    # fetch all folders
    for folder in os.listdir(source_base_folder):

        source_folder = source_base_folder+folder
        destination_folder = destination_base_folder+folder

        if(os.path.isdir(source_folder)):
            print(source_folder)

            # os.mkdir(destination_base_folder+folder)

            # fetch all files in the given folder
            for file_name in os.listdir(source_folder):
                # construct full file path
                source = source_folder+"/" + file_name

                destination = destination_folder+"/"+file_name

                if os.path.isfile(source):
                    # copy file
                    # shutil.copy(source, destination)

                    # push file to git with updated date
                    date = f"{filesCount} days ago"
                    print('dates ', date)

                    # os.system('git add .')

                    spacedFileName = solution(
                        file_name).replace(".java", "").strip()
                    print(spacedFileName, "\n")
                    commitString = 'git commit --date="' + \
                        date + '" -m "'+spacedFileName+' Program committed."'
                    # os.system(commitString)
                    print(commitString)
                    filesCount = filesCount+1

    # if days < 1:
    #     os.system('git push')
    # else:
    #     dates = f"{days} days ago"
    #     with open('data.txt', 'a') as file:
    #         file.write(f'{dates} <- this was the commit for the day!!\n')

    #     # staging
    #     os.system('git add data.txt')

    #     # commit
    #     os.system('git commit --date="' + dates +
    #               '" -m "First commit for the day!"')

    #     return days * makeCommits(days - 1)


makeCommits()
