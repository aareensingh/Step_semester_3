class Question:
    def __init__(self, question_text, correct_answer, student_answer, points):
        self.question_text = question_text
        self.correct_answer = correct_answer
        self.student_answer = student_answer
        self.points = points

    def evaluate(self):
        return 0.0


class MCQ(Question):
    def evaluate(self):
        if self.student_answer == self.correct_answer:
            return float(self.points)
        return 0.0


class TF(Question):
    def evaluate(self):
        if self.student_answer == self.correct_answer:
            return float(self.points)
        return 0.0


class Essay(Question):
    def evaluate(self):
        keywords = [word.strip().lower() for word in self.correct_answer.split(",")]
        answer = self.student_answer.lower()

        count = 0

        for keyword in keywords:
            if keyword in answer:
                count += 1

        if count >= 2:
            return self.points * 0.75
        elif count == 1:
            return self.points * 0.50
        else:
            return 0.0


class ExaminationGrader:
    def __init__(self):
        self.questions = []

    def add_question(self, question):
        self.questions.append(question)

    def grade(self):
        total = 0.0

        for question in self.questions:
            score = question.evaluate()
            print(f"{question.__class__.__name__.upper()}: {score:.2f}")
            total += score

        print(f"Total Score: {total:.2f}")


def parse_input(line):
    parts = []
    current = ""
    inside_quotes = False

    for char in line:
        if char == '"':
            inside_quotes = not inside_quotes
        elif char == " " and not inside_quotes:
            if current:
                parts.append(current)
                current = ""
        else:
            current += char

    if current:
        parts.append(current)

    return parts


n = int(input())
grader = ExaminationGrader()

for i in range(n):
    data = parse_input(input())

    question_type = data[0]
    question_text = data[1]
    correct_answer = data[2]
    student_answer = data[3]
    points = int(data[4])

    if question_type == "MCQ":
        question = MCQ(question_text, correct_answer, student_answer, points)
    elif question_type == "TF":
        question = TF(question_text, correct_answer, student_answer, points)
    else:
        question = Essay(question_text, correct_answer, student_answer, points)

    grader.add_question(question)

grader.grade()
