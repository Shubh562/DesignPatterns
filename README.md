# DesignPatterns
Implementation of various design patterns
1. Singleton design pattern: implemented for both normal enviroment and multithreaded enviroment.
2. Prototyp design pattern
3. Builder design pattern








function Item(id, parentId) {
  this.id = id;
  this.parentId = parentId;
}

var items = [
  new Item(101, 0),
  new Item(102, 101),
  new Item(103, 101),
  new Item(104, 102),
  new Item(105, 0)
];

function deleteChildren(inputId, items) {
  var itemsMap = {};
  var childrenMap = {};

  items.forEach(function(item) {
    itemsMap[item.id] = item;
    if (!childrenMap[item.parentId]) {
      childrenMap[item.parentId] = [];
    }
    childrenMap[item.parentId].push(item.id);
  });

  var deleteQueue = childrenMap[inputId] ? childrenMap[inputId].slice() : [];

  while (deleteQueue.length > 0) {
    var currentId = deleteQueue.shift();
    if (childrenMap[currentId]) {
      deleteQueue = deleteQueue.concat(childrenMap[currentId]);
    }
    delete itemsMap[currentId];
  }

  var updatedItems = [];
  for (var key in itemsMap) {
    if (itemsMap.hasOwnProperty(key)) {
      updatedItems.push(itemsMap[key]);
    }
  }
  
  return updatedItems;
}

var inputId = 101;
var result = deleteChildren(inputId, items);
result.forEach(function(item) {
print("ID: " + item.id + ", Parent ID: " + item.parentId);
});

