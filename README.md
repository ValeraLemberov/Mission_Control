# Mission Control
В данной application реализована логика работы с билетами, багажом и купонами на скинду.

Чтобы запустить это приложение необходимо: fork этого репозитория и запустить в Intellij IDEA.
Чтобы отправить запросы необходимо использовать Postman по url http://localhost:8080/.

Имеются такие end points:
1. /baggage/add-destination?destinationId={} - укажите id destination для создание назначения.
2. /baggage/add-baggage?destinationI={}&baggageId={} - укажите id destination и id baggage для назначения багажа.
3. /baggage/remove-baggage?destinationId={}&baggageId={} - укажите id destination и id baggage для удаления багажа по этому назначению.
4. /baggage/check-baggage?destinationId={}&baggageId={} - укажите id destination и id baggage для проверки багажа по этому назначению.
5. /baggage/remove-destination?destinationId={} - укажите id destination для удалуния назначения из базы данных.
6. /coupon?couponId={}&price={} - укажите id купона и цену что бы получить новую цену с применением скидки.
7. /bookings/check{} - укажите id билета чтобы проверить забранирова ли место по этому id.
8. /bookings/add{} - укажите id билета чтобы его забронировать.
9. /bookings/delete{} - укажите id билета чтобы снять бронь.

Также, все GET запросы кешируються.
