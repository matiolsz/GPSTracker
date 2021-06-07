# GPSTracker
Zaimplementować wydajną usługę REST, której zadaniem będzie odbieranie i
zapisywanie informacji o pozycjach (geolokalizacji) z urządzeń mobilnych np.
telefon/lokalizator GPS.

Specyfikacja implementacyjna 
1. Klasy domenowe
  - Device
    - id
    - name 
    - lista pomiarów(List<Measurement>)
 - Measurement
   - id
   - latitiude
   - longitiude
   - deviceId 
   
2. Kontrolery
  - DeviceController
    - create ( tworzy device z formatu json podanego w body żądania)
    - getAll (zwraca listę List<Device>)
    - getOne ( zwraca jedno Device o danym id podanym w ścieżce URI)
    - deleteAll ( kasuje wszystkie Device )
    - delete ( kasuje jedno Device o danym id podanym w ścieżce URI)
    - put ( aktualizuje podany Device )
 - MeasurementController
    - create ( tworzy measurement z formatu json podanego w body żądania)
    - getAll  (zwraca listę List<Measurement>)
    - getOne ( zwraca jeden Measurement o danym id podanym w ścieżce URI)
    - deleteAll ( kasuje wszystkie Measurement )
    - delete ( kasuje jeden Measurement o danym id podanym w ścieżce URI)
    - put ( aktualizuje podany measurement )
3. Serwisy
  - DeviceService
    - existsById 
    - getOne
    - findAll
    - create
    - delete
    - deleteAll
  - MeasurementService
    - existsById
    - getOne
    - findAll
    - create
    - delete
    - deleteAll
4. Repozytoria
