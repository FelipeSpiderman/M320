package Felipe\M4\User\User.java;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        user.setUserId(GeneratedValue());
        user.setName()
        return userRepository.save(user)
    }

    public Book createBook(Book book) {
        if (book.getPublisher() == null || book.getPublisher().getPublisherId() == null) {
            throw new IllegalArgumentException("Publisher is required");
        }

        Publisher publisher = publisherRepository.findById(book.getPublisher().getPublisherId())
                .orElseThrow(() -> new RuntimeException("Publisher not found"));

        book.setPublisher(publisher);
        book.setBookId(UUID.randomUUID());
        return bookRepository.save(book);
    }

    public Book getBookById(UUID id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<Book> getAllBooks(String title, String language, Publisher publisher) {
        if (title != null && !title.isEmpty()) {
            return bookRepository.findByTitle(title);
        }
        if (language != null && !language.isEmpty()) {
            return bookRepository.findByLanguage(language);
        }
        if (publisher != null) {
            return bookRepository.findByPublisher(publisher);
        }
        return bookRepository.findAll();
    }

    public Book updateBook(UUID id, Book updatedBook) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setLanguage(updatedBook.getLanguage());
        existingBook.setPrice(updatedBook.getPrice());
        existingBook.setPublisher(updatedBook.getPublisher());
        return bookRepository.save(existingBook);
    }

    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
}