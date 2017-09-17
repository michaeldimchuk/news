export function resolveText(text) {
  var data = window.TEXT[text];
  if(!data) {
    return text;
  }
  return data;
};