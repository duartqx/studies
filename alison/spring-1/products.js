const findByName = async () => {
  const response = await fetch("http://localhost:8080/products/findByName", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ names: ["first product", "third product"] }),
  });

  const j = await response.json();

  console.log(j);
};

const post = async () => {
  const products = [
    {
      name: "first product",
      category: "common",
      type: "normal",
      sector: "2",
    },
    {
      name: "second product",
      category: "uncommon",
      type: "silver",
      sector: "3",
    },
    {
      name: "third product",
      category: "rare",
      type: "gold",
      sector: "1",
    },
  ];

  for (const product of products) {
    const response = await fetch("http://localhost:8080/products", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(product),
    });

    const data = await response.json();

    console.log(data);
  }
};

findByName();
