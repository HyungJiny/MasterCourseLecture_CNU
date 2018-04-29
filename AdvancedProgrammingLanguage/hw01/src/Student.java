class Student {
    /*
    Student는 대학원생을 나타내는 클래스이며,
    필드 examPassed는 종합시험의 통과 여부를 나타내고(통과하면 True),
    thesisProposed는 논문 심사 요청(proposal)을 했는지 여부를 나타낸다.
    */

    String id;
    // ...
    Boolean examPassed;
    Boolean thesisProposed;

    public Student(String id, Boolean examPassed, Boolean thesisProposed){
        this.id = id;
        this.examPassed = examPassed;
        this.thesisProposed = thesisProposed;
    }

    public String getId(){
        return id;
    }

    public Boolean getExamPassed() {
        return examPassed;
    }

    public Boolean getThesisProposed() {
        return thesisProposed;
    }
}
