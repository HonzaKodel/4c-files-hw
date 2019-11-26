# DÚ
## Zpracovat json soubor s resources

*kasa-items.json* - jeden item
```json
{
  "originalPrice": 11753,
  "currentPrice": 9990,
  "discounted": true,
  "img": "https://img.kasa.cz/k-foto/280/5/0/6/product_3338605.jpg",
  "itemId": 1420766,
  "itemUrl": "https://www.kasa.cz/trouba-electrolux-eob3454aox-nerez-ocel/",
  "itemName": "Trouba Electrolux EOB3454AOX nerez/ocel",
  "category": "KASA.cz > Vestavné domácí spotřebiče > Vestavné trouby"
}
```

kasa items obsahuje jednoduchý výčet produktů z jednotlivých kategorií z webu kasa.cz

Vaším úkolem je vytvořit několik metod pracujících s daty v souboru:

- Vytvořte metodu, která vytvoří z prvních 50. produktů strom kategorií
- Vytvořte metodu, která seřadí produkty podle nejnižší ceny
- Vytvořte medodu, která vypíše pouze zlevněné produkty