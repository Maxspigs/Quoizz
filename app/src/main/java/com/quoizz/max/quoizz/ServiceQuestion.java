package com.quoizz.max.quoizz;

public class ServiceQuestion {

    public static Question[] populate(){
        Question[] questionnaire = new Question[]{
                new Question(1, "Un programme est un ensemble d’instructions. ", true),
                new Question(2, "Quand on parle de langage de programmation, on désigne l’anglais qui est la langue utilisée par les informaticiens pour communiquer entre eux. ", false),
                new Question(3, "L’homme et la machine ont une intelligence similaire.", false),
                new Question(4, "Il y a de nombreux langages de programmation. ", true),
                new Question(5, "Les langages de programmation ont un vocabulaire très riche. ", false),
                new Question(6, "Il faut être très rigoureux pour écrire un programme correct.", true),
                new Question(7, "Il faut bien connaître la sémantique des instructions. ", true),
                new Question(8, "L’écriture musicale et les langages de programmation ont finalement une structure assez similaire. ", true),
                new Question(9, "Une fois que l’on a écrit un programme, l’ordinateur peut l’exécuter immédiatement. ", false),
                new Question(10,"Dans un ordinateur, toutes les données sont ultimement écrites sous forme binaire. ", true)
        };
        return questionnaire;
    }

}
