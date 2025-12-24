# Домашнее задание: Инструментирование сервиса метриками Prometheus

## 📋 Цель
Научиться инструментировать сервис метриками в формате Prometheus с использованием библиотек, соответствующих вашему фреймворку и языку программирования.

---

## 🛠️ Описание задания

### ✅ Обязательные требования

#### 1. Инструментирование сервиса
- Добавить в сервис из предыдущего ДЗ метрики в формате Prometheus
- Использовать соответствующую библиотеку для вашего стека технологий

#### 2. Дашборд в Grafana
Создать дашборд с двумя группами метрик:

**A. Метрики приложения (по API-методам):**
- ✅ **Latency (response time)** с квантилями:
    - 0.5 (медиана)
    - 0.95
    - 0.99
    - max
- ✅ **RPS** (запросов в секунду)
- ✅ **Error Rate** - количество 500-х ответов

**B. Метрики nginx-ingress-controller (по сервису в целом):**
- ✅ **Latency** с квантилями 0.5, 0.95, 0.99, max
- ✅ **RPS**
- ✅ **Error Rate** - количество 500-х ответов

#### 3. Алертинг в Grafana
- Настроить алерты на:
    - ✅ Высокий **Error Rate**
    - ✅ Высокую **Latency**

---

## 📤 Результаты выполнения

### Требуемые артефакты:

1. **Скриншоты дашборда** 📸
    - В момент стресс-тестирования сервиса
    - После 5-10 минут нагрузки
    - Показать все графики и метрики

2. **JSON-экспорт дашборда** 📄
    - Экспортированный дашборд из Grafana в формате JSON
    - Файл должен содержать все панели и настройки

---

## ⭐ Задание со звёздочкой (опционально)

### Уровень 1: Системные метрики Kubernetes
Добавить на дашборд графики с системными метриками:
- 📊 Потребление памяти подами приложения
- ⚙️ Потребление CPU подами приложения

### Уровень 2: Мониторинг базы данных
1. **Инструментировать БД** с помощью экспортера для Prometheus
2. **Добавить на дашборд** графики с метриками работы БД:
    - Количество подключений
    - Запросов в секунду
    - Время выполнения запросов
    - Использование ресурсов БД

---

## Используемые команды

```bash
cd hw05
docker build -t a1exander78/hw05:latest .
docker push a1exander78/hw05:latest
helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm repo update
helm install stack prometheus-community/kube-prometheus-stack -f "путь к prometheus.yaml"

helm repo add bitnami https://charts.bitnami.com/bitnami
kubectl create namespace database
helm install postgres bitnami/postgresql -f k8s/01-database/values.yaml --namespace database

kubectl apply -f k8s/02-app-config/
kubectl apply -f k8s/03-manifests/

kubectl port-forward service/prometheus-operated  9090

while ($true) {
    & "C:\Users\admin\AppData\Roaming\Apache24\bin\ab.exe" -n 50 -c 10 http://arch.homework/api/v1/users/2
    Start-Sleep -Seconds 1
}

histogram_quantile(0.5, 
  sum by(le, uri, method) (
    rate(http_server_requests_seconds_bucket{uri=~"/api/v1/.*"}[$__rate_interval])
  )
)

sum(rate(nginx_ingress_controller_requests[$__rate_interval]))


kubectl port-forward service/stack-grafana  9000:80
admin / prom-operator