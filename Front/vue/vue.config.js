module.exports = {
    outputDir: '../../src/main/resources',
    devServer: {
        overlay: false,
        port: 80,
        proxy: {
            '/api': {
                target: 'http://localhost:80',
            },
        },
    },
};
