
# Auxilium backend

Main backend service which launched with frontend. Service provides primary
    integrations with OpenAI, LLaMa service and GPT4ALL micro-services.
    Mostly service works as centralizator of all requests.

## Deploy

For propper deploy we recomend using Docker.

1. `docker-compose -f docker-compose.yml up`

That's all. Service will be launched in development mode, for production mode,
    change credentials and file `.env`.
