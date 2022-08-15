curl -X POST http://localhost:8080/feedback \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  -d 'emailId=abc%40example.com&comment=Sample%20Feedback'

curl -X POST http://localhost:8080/feedback \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  --data-urlencode 'emailId=abc@example.com' \
  --data-urlencode 'comment=sample feedback'


