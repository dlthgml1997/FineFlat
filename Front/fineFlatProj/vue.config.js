module.exports = {
    // outputDir: '../../src/main/resources',
    devServer: {
        port: 81,
        //port: 8080,
        overlay: false,
        proxy: {
            '/api': {
                target: 'http://localhost:80', //연결할 백 포트
            },
        },
    },
    publicPath: process.env.NODE_ENV === 'production' ? './' : '', // 정적 리소스의 경로를 상대 경로로 지정한다.
    outputDir: '../backend/src/main/resources/static', // 정적 파일 생성 위치
    assetsDir: '', // js, css, img 파일 생성 위치
    indexPath: '../templates/index.html', // index.html 파일이 생성되는 위치
    // devServer: {
    //     proxy: {
    //         '/': {
    //             target: 'localhost:8090',
    //             ws: true,
    //             changeOrigin: true
    //         }
    //     }
    // }
};
