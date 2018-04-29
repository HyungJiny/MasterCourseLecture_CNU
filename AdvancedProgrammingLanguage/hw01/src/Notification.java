import java.util.AbstractList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

class Notification implements Runnable{
    /*
    아래 클래스 Notification 에서 필드 List<Student> students 는 현재학생들의
    리스트를 나타낸다고 가정할 때, students 중에서 종합시험은 통과했지만 논문 심사
    요청은 아직 하지 않은 학생들의 리스트를 static 메소드
    getPassedButNotProposed()를 통해 아래와 같이 받아온다고 한다. 이 메소드를
    구현의 빈칸을 채우시오. 단, 리턴된 후에도 students 가 변화되면 메소드 결과
    리스트도 함께 연동되어 변화를 반영하도록 하시오.
     */

    private List<Student> students;
    private List<Student> studentToNotify;

    public Notification(List<Student> students){
        this.students = students;
        this.studentToNotify = getPassedButNotProposed(students);
    }

    private static List<Student> getPassedButNotProposed(List<Student> students) {
        return new AbstractList<Student>() {
            // 구현 부분
            public boolean isPassedButNotProposed(Student student){
                // 종합시험 통과, 논문 심사 요청 아직
                return student.getExamPassed() && !student.getThesisProposed();
            }

            @Override
            public Student get(int index) {
                return students.get(index);
            }

            @Override
            public int size() {
                // 학생수 반환
                int length = (int) students.stream().filter(student -> isPassedButNotProposed(student)).count();
                return length;
            }

            @Override
            public String toString() {
                // 포함된 학생 수
                StringBuffer stringBuffer = new StringBuffer("student id : ");
                Stream<Student> pickedStudents = students.stream().filter(student -> isPassedButNotProposed(student));
                pickedStudents.forEach(student -> stringBuffer.append(student.getId()+", "));
                return stringBuffer.toString();
            }
        };
    }

    @Override
    public void run() {
        System.out.print(studentToNotify.toString());
        System.out.println("\t("+studentToNotify.size()+")");
    }
}
