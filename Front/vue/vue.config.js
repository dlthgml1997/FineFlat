module.exports = {
  outputDir: '../../src/main/resources',
  devServer: {
    port: 80,
    proxy: {
      '/api': {
        target: 'http://localhost:80',
      },
    },
  },
};
