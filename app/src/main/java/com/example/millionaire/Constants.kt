package com.example.millionaire

object Constants{

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val q1 = Question(1,"In what children's game are participants chased by someone designated \"It\"?",
            "Tag",
            "Simon Says",
            "Charades",
            "Hopscotch",
            0
        )

        questionsList.add(q1)

        val q2 = Question(2,"On a radio, stations are changed by using what control?", "Tuning",
            "Volume",
            "Bass",
            "Treble", 0)
        questionsList.add(q2)

        val q3 = Question(3,"Which material is most dense?", "Silver",
            "Styrofoam",
            "Butter",
            "Gold", 3)
        questionsList.add(q3)

        val q4 = Question(4,"Which state in the United States is largest by area?",  "Alaska",
            "California",
            "Texas",
            "Hawaii", 0)
        questionsList.add(q4)

        val q5 = Question(5,"Which part of the body are you most likely to \"stub\"?",  "Toe",
            "Knee",
            "Elbow",
            "Brain", 0)
        questionsList.add(q5)

        val q6 = Question(6,"Which country is largest by area?",  "UK",
            "USA",
            "Russia",
            "China", 2)
        questionsList.add(q6)

        val q7 = Question(7,"What does the \"F\" stand for in FBI?", "Foreign",
            "Federal",
            "Flappy",
            "Face", 1)
        questionsList.add(q7)

        val q8 = Question(8,"An albino gorilla usually has what color fur?", "Brown",
            "Black",
            "White",
            "Golden", 2)
        questionsList.add(q8)

        val q9 = Question(9,"What is the national emblem of Canada?",  "Maple Leaf",
            "Brown Bear",
            "Maple Syrup",
            "Waffle", 0)
        questionsList.add(q9)

        val q10 = Question(10,"Galileo was an Italian astronomer who",  "developed the telescope",
            "discovered four satellites of Jupiter",
            "discovered that the movement of pendulum produces a regular time measurement",
            "All of the above", 3)
        questionsList.add(q10)

        return questionsList
    }
}