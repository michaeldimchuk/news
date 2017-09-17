export function generateLinks(data, generator, args) {
  var links = [];
  for(let i = 0; i < data.length; i++) {
    let element = data[i];
    links.push(generator(i, element.text, element.url, args));
  }
  return links;
};