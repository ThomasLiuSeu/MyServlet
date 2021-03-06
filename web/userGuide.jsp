<%@ page language="java"  pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%--<%@ taglib prefix="jawr" uri="http://jawr.net/tags"%>--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Release Notes Test</title>

    <!-- <link rel="stylesheet" type="text/css" href="css/style.css"> -->
    <style type="text/css">
        *{margin:0;padding:0;list-style-type:none;}
        a,img{border:0;}
        body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体";}
            /* case */
        .case{height:530px;overflow:hidden;width:760px;margin:0 0;}
        .case_box{position:relative;margin:0px auto 0px;width:760px;height:530px;overflow:hidden}
        .case_box p{z-index:2;position:absolute;text-indent:-9999px;width:28px;height:51px;top:40%;cursor:pointer}
        .case_box .prev{text-indent:-9999px;background:url(image/releaseNotes/leftaward.png) no-repeat;left:0px;width:50px;}
        .case_box .next{background:url(image/releaseNotes/rightaward.png) no-repeat;top:40%;right:0px;width:50px;}
        .case_box ul{position:absolute;height:530px;overflow:hidden;top:0px;left:0px}
        .case_box ul li{width:860px;float:left;height:530px}
        .case_box ul li dl.case_info{line-height:17px;margin:95px 0px 0px 475px;width:295px;zoom:1;color:#616741;font-size:13px;overflow:hidden}
        .case_box ul li dl.case_info dd{text-indent:26px}

        .case_box ul li.case_1{background:url(image/releaseNotes/RN1.9.0.1.png) no-repeat left top}
        .case_box ul li.case_2{background:url(image/releaseNotes/RN1.9.0.2.png) no-repeat left top}
        .case_box ul li.case_3{background:url(image/releaseNotes/RN1.9.0.3.png) no-repeat left top}
        .case_box ul li.case_4{background:url(image/releaseNotes/RN1.9.0.4.png) no-repeat left top}
        .case_box ul li.case_5{background:url(image/releaseNotes/RN1.9.0.5.png) no-repeat left top}
        .case_box ul li.case_6{background:url(image/releaseNotes/RN1.9.0.6.png) no-repeat left top}
        .case_box ul li.case_7{background:url(image/releaseNotes/RN1.9.0.7.png) no-repeat left top}
            /*.case_box ul li.case_5{background:url(image/releaseNotes/RN1.9.0_5.png) no-repeat left top}*/

        .case_box ul li.case_2 dl{margin-top:150px}
        .case_box ul li.case_3 dl{margin-top:135px}
        .case_box ul li.case_4 dl{margin-top:110px}
        .case_box ul li.case_5 dl{margin-top:120px}

        .case_info_add dd{line-height:22px}

        .case_box ol{position:absolute;bottom:3%;left:48%;margin:0 0 0 -80px;height:12px;z-index:99;}
        .case_box ol li{float:left;margin:0 4px;display:inline;width:12px;height:12px;line-height:999em;background:url(image/releaseNotes/pagination.png) no-repeat;overflow:hidden;cursor:pointer;}
        .case_box ol li.active{background-position:0 -12px;}

        #slider {background:url(image/releaseNotes/RN1.9.0.bg.jpg)}
    </style>
</head>
<body>

<div class="case">
    <div id="slider" class="case_box">
        <ul>
            <li class="case_1"></li>
            <li class="case_2"></li>
            <li class="case_3"></li>
            <li class="case_4"></li>
            <li class="case_5"></li>
            <li class="case_6"></li>
            <li class="case_7"></li>
        </ul>
    </div>
</div>


<script type="text/javascript">

    var Effect = (function() {

        var Slider = function(o) {
            this.setting      = typeof o === 'object' ? o : {};
            this.target       = this.setting.target || 'slider';
            this.showMarkers  = this.setting.showMarkers || false;
            this.showControls = this.setting.showControls || false;
            this.timer        = null;
            this.currentTime  = null;
            this.ms           = 35;
            this.autoMs       = 5000;
            this.iTarget      = 0;
            this.nextTarget   = 0;
            this.speed        = 0;

            this.init();
            this.handleEvent();
        };

        Slider.prototype = {
            init: function() {
                this.obj      = document.getElementById(this.target);
                this.oUl      = this.obj.getElementsByTagName('ul')[0];
                this.aUlLis   = this.oUl.getElementsByTagName('li');
                this.width    = this.aUlLis[0].offsetWidth;
                this.number   = this.aUlLis.length;

                this.oUl.style.width = this.width * this.number + 'px';

                if(this.showMarkers) {
                    var oDiv = document.createElement('div');
                    var aLis = [];
                    for(var i = 0; i < this.number; i++) {
                        aLis.push('<li>'+ (i+1) +'<\/li>');
                    };
                    oDiv.innerHTML = '<ol>'+ aLis.join('') +'<\/ol>';
                    this.obj.appendChild(oDiv.firstChild);
                    this.aLis = this.obj.getElementsByTagName('ol')[0].getElementsByTagName('li');
                    this.aLis[0].className = 'active';
                    oDiv = null;
                };

                if(this.showControls) {
                    this.oPrev = document.createElement('p');
                    this.oNext = document.createElement('p');
                    this.oPrev.className = 'prev';
                    this.oPrev.innerHTML = '&laquo;';
                    this.oNext.className = 'next';
                    this.oNext.innerHTML = '&raquo;';
                    this.obj.appendChild(this.oPrev);
                    this.obj.appendChild(this.oNext);

                };

            },

            handleEvent: function() {
                var that = this;

                this.currentTime = setInterval(function() {
                    that.autoPlay();
                }, this.autoMs);

                this.addEvent(this.obj, 'mouseover', function() {
                    clearInterval(that.currentTime);
                });

                this.addEvent(this.obj, 'mouseout', function() {
                    that.currentTime = setInterval(function() {
                        that.autoPlay();
                    }, that.autoMs);
                });

                if(this.showMarkers) {
                    for(var i = 0; i < this.number; i++) {
                        var el = this.aLis[i];
                        (function(index) {
                            that.addEvent(el, 'mouseover', function() {
                                that.goTime(index);
                            });
                        })(i);
                    };
                };

                if(this.showControls) {
                    this.addEvent(this.oPrev, 'click', function() {
                        that.fnPrev();
                    });
                    this.addEvent(this.oNext, 'click', function() {
                        that.autoPlay();
                    });
                };

            },

            addEvent: function(el, type, fn) {
                if(window.addEventListener) {
                    el.addEventListener(type, fn, false);
                }
                else if(window.attachEvent) {
                    el.attachEvent('on' + type, fn);
                };
            },

            fnPrev: function() {
                this.nextTarget--;
                if(this.nextTarget < 0) {
                    this.nextTarget = this.number - 1;
                };
                this.goTime(this.nextTarget);
            },

            autoPlay: function() {
                this.nextTarget++;
                if(this.nextTarget >= this.number) {
                    this.nextTarget = 0;
                };
                this.goTime(this.nextTarget);
            },

            goTime: function(index) {
                var that = this;

                if(this.showMarkers) {
                    for(var i = 0; i < this.number; i++) {
                        i == index ? this.aLis[i].className = 'active' : this.aLis[i].className = '';
                    };
                };

                this.iTarget = -index * this.width;
                if(this.timer) {
                    clearInterval(this.timer);
                };
                this.timer = setInterval(function() {
                    that.doMove(that.iTarget);
                }, this.ms);
            },

            doMove: function(target) {
                this.oUl.style.left = this.speed + 'px';
                this.speed += (target - this.oUl.offsetLeft) / 3;
                if(Math.abs(target - this.oUl.offsetLeft) === 0) {
                    this.oUl.style.left = target + 'px';
                    clearInterval(this.timer);
                    this.timer = null;
                };
            }

        };

        return {

            slider: function(o) {
                var tt = new Slider(o);
            }
        };
    })();

    // 调用语句
    Effect.slider({
        'targetElement': 'slider',
        'showMarkers': true,
        'showControls': true,
        'autoMs' : 4000
    });
</script>
</body>
</html>