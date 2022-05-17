# laebrari
digital home library, allows users to lend, sell or borrow books
- User - to allow login/logout, registration, pass reset
- Librarian - user id, first name, last name, email, phone number, location, date joined

        - lender info (rating, no. of books loaned) 
        - borrower info (rating, no. of books borrowed, no. of books returned)
- Library 
    - librarian (profile)
    - rating
    - location
    - library type(private, public, unlisted)
    - contact info
- Book 
    - title, author, isbn, acquisition note, 
    - can_sell, can_loan, 
    - library id
    - date_acquired, book_condition
    - selling_price, borrowing_price
    - for future (language, genre)
- Book Transaction 
    - transaction type,
    - book, 
    - date of transaction, transaction end date
    - transaction initator
    - transaction status (borrowed, sold, reserved, overdue)
- Transaction Rating 
    - borrower, lender, rating, lender's note, transaction ID
- Library Rating 
    - rating, borrower's note, transaction ID