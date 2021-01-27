# spring-cloud-example
> _**Note**_ that I use each component as a independent service, actually many of these should be use in combination, eg:
>* all the service should include the `config-client` so that can manage the config from one place(git) and read from `config-server`.
>* every service which want to use RPC need to integrate with `feign`.

> _**Note**_ that the config with peer suffix means `HA(High Available)` solution

**Recommend Steps**
1. eureka-server
2. eureka-client
3. load-balance
4. feign
5. resilience4j
6. config-server
7. config-client