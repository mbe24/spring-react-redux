// see: https://facebook.github.io/create-react-app/docs/proxying-api-requests-in-development
const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function (app) {
  app.use(
    '/app/api',
    createProxyMiddleware({
      target: 'http://localhost:8080/',
      changeOrigin: true,
    }),
  );
};
