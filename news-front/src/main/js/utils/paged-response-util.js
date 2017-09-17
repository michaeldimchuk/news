export function canRequestMore() {
  var body = window.DATA.body;
  if(body.feedMode === 'NORMAL') {
    return body.pagination.hasMore && !body.requestInProgress;
  }
  return false;
};

export function generateUrl() {
  var body = window.DATA.body;
  var context = window.location.origin + body.contextPath;
  return context + body.category + "/" + (body.pagination.currentPage + 1);
};

export function enableLoading(status) {
  window.DATA.body.requestInProgress = status;
};

export function updateBody(data, updatedArticles) {
  window.DATA.body.pagination = data.pagination;
  window.DATA.body.articles = updatedArticles;
};

export function needsMorePages(body) {
  var h = document.documentElement,
      b = document.body,
      st = 'scrollTop',
      sh = 'scrollHeight';
  var percent = (h[st]||b[st]) / ((h[sh]||b[sh]) - h.clientHeight) * 100;
  return percent > 70;
};

export function isPaginationEnabled() {
  var body = window.DATA.body;
  return body.feedMode === "NORMAL" && body.mode === "NORMAL";
};