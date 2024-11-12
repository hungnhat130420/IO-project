java.lang.Object
└── java.io.Closeable
└── java.io.Flushable
├── java.io.InputStream (abstract)
│   ├── java.io.ByteArrayInputStream
│   ├── java.io.FileInputStream
│   ├── java.io.FilterInputStream (abstract)
│   │   ├── java.io.BufferedInputStream
│   │   ├── java.io.DataInputStream
│   │   ├── java.io.PushbackInputStream
│   │   └── java.util.zip.GZIPInputStream
│   ├── java.io.PipedInputStream
│   └── java.net.URLConnection$URLConnectionInputStream
│
├── java.io.OutputStream (abstract)
│   ├── java.io.ByteArrayOutputStream
│   ├── java.io.FileOutputStream
│   ├── java.io.FilterOutputStream (abstract)
│   │   ├── java.io.BufferedOutputStream
│   │   ├── java.io.DataOutputStream
│   │   └── java.io.PrintStream
│   ├── java.io.PipedOutputStream
│   └── java.util.zip.GZIPOutputStream
│
├── java.io.Reader (abstract)
│   ├── java.io.BufferedReader
│   ├── java.io.CharArrayReader
│   ├── java.io.FilterReader (abstract)
│   │   ├── java.io.InputStreamReader
│   │   ├── java.io.LineNumberReader
│   │   └── java.io.PushbackReader
│   ├── java.io.FileReader
│   ├── java.io.PipedReader
│   └── java.io.StringReader
│
└── java.io.Writer (abstract)
├── java.io.BufferedWriter
├── java.io.CharArrayWriter
├── java.io.FilterWriter (abstract)
│   ├── java.io.OutputStreamWriter
│   ├── java.io.PrintWriter
│   └── java.io.StringWriter
├── java.io.FileWriter
├── java.io.PipedWriter
└── java.io.StringWriter

Các lớp khác trong **`java.io`**:

- **java.io.File**: Đại diện cho tệp và thư mục trong hệ thống tệp.
- **java.io.RandomAccessFile**: Cho phép đọc và ghi vào bất kỳ vị trí nào trong tệp.
- **java.io.ObjectInputStream** và **java.io.ObjectOutputStream**: Cho phép tuần tự hóa và giải tuần tự hóa các đối tượng.
- **java.io.Serializable**: Giao diện đánh dấu các lớp có thể được tuần tự hóa.
- **java.io.Console**: Cung cấp phương thức để tương tác với console.

### Giải Thích Chi Tiết

#### 1. **InputStream và Các Lớp Kế Thừa**

- **`InputStream`** là lớp trừu tượng cơ bản cho tất cả các luồng byte đầu vào.
    - **`FileInputStream`**: Đọc dữ liệu từ tệp tin.
    - **`ByteArrayInputStream`**: Đọc dữ liệu từ mảng byte trong bộ nhớ.
    - **`BufferedInputStream`**: Cung cấp bộ đệm cho các luồng đầu vào khác để tăng hiệu suất.
    - **`DataInputStream`**: Đọc dữ liệu Java nguyên thủy từ luồng đầu vào.
    - **`PushbackInputStream`**: Cho phép đẩy lại (unread) byte vào luồng.
    - **`GZIPInputStream`**: Giải nén dữ liệu nén theo định dạng GZIP.
    - **`PipedInputStream`**: Cho phép giao tiếp giữa các luồng thông qua ống dẫn.

#### 2. **OutputStream và Các Lớp Kế Thừa**

- **`OutputStream`** là lớp trừu tượng cơ bản cho tất cả các luồng byte đầu ra.
    - **`FileOutputStream`**: Ghi dữ liệu vào tệp tin.
    - **`ByteArrayOutputStream`**: Ghi dữ liệu vào mảng byte trong bộ nhớ.
    - **`BufferedOutputStream`**: Cung cấp bộ đệm cho các luồng đầu ra khác để tăng hiệu suất.
    - **`DataOutputStream`**: Ghi dữ liệu Java nguyên thủy vào luồng đầu ra.
    - **`PrintStream`**: Ghi các giá trị có định dạng vào luồng đầu ra (ví dụ: `System.out`).
    - **`GZIPOutputStream`**: Nén dữ liệu theo định dạng GZIP.
    - **`PipedOutputStream`**: Cho phép giao tiếp giữa các luồng thông qua ống dẫn.

#### 3. **Reader và Các Lớp Kế Thừa**

- **`Reader`** là lớp trừu tượng cơ bản cho tất cả các luồng ký tự đầu vào.
    - **`FileReader`**: Đọc dữ liệu ký tự từ tệp tin.
    - **`BufferedReader`**: Cung cấp bộ đệm cho các luồng ký tự đầu vào khác để tăng hiệu suất và hỗ trợ đọc dòng.
    - **`InputStreamReader`**: Chuyển đổi luồng byte thành luồng ký tự.
    - **`LineNumberReader`**: Theo dõi số dòng đã đọc.
    - **`StringReader`**: Đọc dữ liệu từ chuỗi trong bộ nhớ.
    - **`PushbackReader`**: Cho phép đẩy lại (unread) ký tự vào luồng.
    - **`PipedReader`**: Cho phép giao tiếp giữa các luồng thông qua ống dẫn.

#### 4. **Writer và Các Lớp Kế Thừa**

- **`Writer`** là lớp trừu tượng cơ bản cho tất cả các luồng ký tự đầu ra.
    - **`FileWriter`**: Ghi dữ liệu ký tự vào tệp tin.
    - **`BufferedWriter`**: Cung cấp bộ đệm cho các luồng ký tự đầu ra khác để tăng hiệu suất.
    - **`OutputStreamWriter`**: Chuyển đổi luồng ký tự thành luồng byte.
    - **`PrintWriter`**: Ghi các giá trị có định dạng vào luồng ký tự đầu ra.
    - **`StringWriter`**: Ghi dữ liệu ký tự vào chuỗi trong bộ nhớ.
    - **`PipedWriter`**: Cho phép giao tiếp giữa các luồng thông qua ống dẫn.

### Các Lớp và Giao Diện Khác

- **`File`**: Đại diện cho tệp và thư mục trong hệ thống tệp, cung cấp các phương thức để thao tác với tệp như tạo, xóa, kiểm tra tồn tại, v.v.
- **`RandomAccessFile`**: Cho phép đọc và ghi vào bất kỳ vị trí nào trong tệp, hỗ trợ cả chế độ đọc và ghi.
- **`ObjectInputStream`** và **`ObjectOutputStream`**: Được sử dụng để tuần tự hóa (serialize) và giải tuần tự hóa (deserialize) các đối tượng Java.
- **`Serializable`**: Giao diện đánh dấu các lớp có thể được tuần tự hóa.
- **`Console`**: Cung cấp các phương thức để tương tác với console, như đọc dòng từ người dùng hoặc ghi ra console.

### Tài Nguyên Thêm

Để hiểu rõ hơn về các lớp trong **`java.io`**, có thể tham khảo tài liệu chính thức của Java tại:

- [Java SE 17 Documentation - java.io Package](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/package-summary.html)

### Kết Luận

Gói **`java.io`** cung cấp một loạt các lớp và giao diện để xử lý I/O (Input/Output) trong Java, bao gồm cả luồng byte và ký tự, thao tác với tệp tin, tuần tự hóa đối tượng, và nhiều tính năng khác. Hiểu rõ phân cấp và mối quan hệ giữa các lớp sẽ giúp bạn lựa chọn đúng lớp phù hợp cho nhu cầu phát triển ứng dụng của mình.
