export class CourseRegistration{
    id: number;
    studentId: number;
    courseId: number;
    courseName: string;
    courseFee: number;
    phase: number;
    session: number;
    regStatus: boolean;
    paymentStatus: boolean;
    dueDate: Date;
    requestDate: Date;
    createdOn: Date;
}

export class Student{
    id: number;
    name: string;
    dob: Date;
    phone: string;
    email: string;
    batch: string;
    prevPhase: number;
    currentPhase: number;
}