using Repositories.Entities;

namespace Services
{
    public class Cabinet<T> 
        //Cái tủ truyền thống có nhiều không gian lưu trữ chính là mảng của gì đó: SV, GV,....
        //Mảng CRUD
        //T: type nào đó bạn muốn dùng
        //Ví dụ Cabinet<Student> box = new Cabinet<Student>()
        //Ví dụ Cabinet<Lecturer> box = new Cabinet<Lecturer>()
        //Coi Data type là tham số, hàm hoặc class nhận vào 1 tham số mà là datatype
        //Class thiết kế tổng quát với nhiều loại data type
    {
        //private Student[] _list1 = new Student[300];
        //private int _count1 = 0;

        //private Lecturer[] _list2 = new Lecturer[300];
        //private int _count2 = 0;

        private T[] _list = new T[300];
        public void AddObject()
        {

        }

    }
}
