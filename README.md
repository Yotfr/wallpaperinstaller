# WallpaperInstaller
Приложение - утилита для установки изображения в качестве обоев рабочего стола смартфона

## ВАЖНО
- Сервис pixabay, как в прочем и многие другие сервисы по подбору картинок не доступны в РФ, поэтому для комфортной работы с приложением
необходим VPN. Приложением предусмотрено отсутствие VPN, оно не вылетит и уведомит о необходимости активации VPN 

### Features :

- Отображает актуальные загруженные обои, и реагирует на удаление обоев из памяти устройства
- Отображает актуальный статус загрузки обоев
- Не загружает повторно изображения, уже загруженные в disk cache с помощью Coil CachePolicy
- Не загружает дважды одни и те же обои
- Отображает актуальный статус установки обоев на устройство
- Обои грузятся постранично
- Обрабатывает ошибки свзяанные с подключением к интернету и отсутствием VPN

---

### Architecture & Tools :

- MVVM Multi-Module( By feature & by layer )
- Hilt
- Coroutines
- Retrofit
- Coil
- Jetpack Compose
- DownloadManager
- Paging3
- Compose Navigation
- DataStore
- Accompanist (systemUiController) ( Из-за несовместимости версий, несмотря на Deprecated статус )

---

### Api documentation :

https://pixabay.com/api/docs/

---
