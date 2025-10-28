/* package Felipe\M4\User\User.java;

@RestController
@RequestMapping("/api/books")
public class UserController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherService publisherService;


    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/{bookId}")
    public Book getBook(@Valid @PathVariable UUID id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String language,
                                  @RequestParam(required = false) Publisher publisher) {

        return bookService.getAllBooks(title, language, publisher);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable UUID id, @Valid @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@Valid @PathVariable UUID id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{bookId}/publishers")
    public Publisher createPublisher(@RequestBody Publisher publisher) {
        return publisherService.createPublisher(publisher);
    }

    @GetMapping("/{bookId}/publishers/{id}")
    public ResponseEntity<Publisher> getPublisher(@Valid @PathVariable UUID id) {
        Publisher publisher = publisherService.getPublisherById(id);
        if (publisher != null) {
            return ResponseEntity.ok(publisher);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/publishers")
    public List<Publisher> getAllPublishers(@RequestParam(required = false) String country,
                                            @RequestParam(required = false) String name) {
        return publisherService.getAllPublishers(country, name);
    }

    @PutMapping("/{bookId}/publishers/{PublisherId}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable UUID id, @Valid @RequestBody Publisher publisher) {
        Publisher updatedPublisher = publisherService.updatePublisher(id, publisher);
        if (updatedPublisher != null) {
            return ResponseEntity.ok(updatedPublisher);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{bookId}/publishers/{publisherId}")
    public ResponseEntity<String> deletePublisher(@Valid @PathVariable UUID id) {
        publisherService.deletePublisher(id);
        return ResponseEntity.noContent().build();
    }
} */