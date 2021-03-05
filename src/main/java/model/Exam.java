package model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.StringJoiner;

/**
 * @author Taimoor Choudhary
 */
@JsonDeserialize(builder = Exam.Builder.class)
public class Exam {

    private String id;
    private String courseId;
    private Long studentId;

    private Exam(String id, String courseId, Long studentId) {
        this.id = id;
        this.courseId = courseId;
        this.studentId = studentId;
    }

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "set")
    public static class Builder {

        private String id;
        private String courseId;
        private Long studentId;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setCourseId(String courseId) {
            this.courseId = courseId;
            return this;
        }

        public Builder setStudentId(Long studentId) {
            this.studentId = studentId;
            return this;
        }

        public Exam build() {
            return new Exam(id, courseId, studentId);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Exam.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("courseId='" + courseId + "'")
                .add("studentId=" + studentId)
                .toString();
    }
}
