module.exports = {
    outputDir: '../../src/main/resources',
    devServer: {
        // port: 81,
        port: 85,
        overlay: false,
        proxy: {
            '/api': {
                target: 'http://localhost:80', //연결할 백 포트
            },
        },
    },
};
