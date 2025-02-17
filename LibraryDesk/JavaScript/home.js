document.querySelector('#form-busca').onsubmit = function(){
	if(document.querySelector('#q').value == ''){
		document.querySelector('#form-busca').style.background = 'red';
		return false;
	}
};

// fazendo a associação da função com o evento
//document.querySelector('#form-busca').onsubmit = validaBusca;

// executa a minhaFunção daqui um segundo
//setTimeout(minhaFuncao, 1000);

// executa a minhaFuncao de um em um segundo
//setInterval(minhaFuncao, 1000);

// agenda uma execução qualquer
//var timer = setInterval(minhaFuncao, 1000);

// cancela a execução
//clearInterval(timer);

/*banner rotativo na home page da Mirror Fashion usando JavaScript.*/
var banners = ["img/destaque-home.png", "img/destaque-home-2.png"];
var bannerAtual = 0;

function trocaBanner(){
	bannerAtual = (bannerAtual + 1) % 2;
	document.querySelector('.destaque img').src = banners[bannerAtual];
}

//setInterval(trocaBanner, 4000);

/*desafio de pause/play*/
var timer = setInterval(trocaBanner, 4000);
var controle = document.querySelector('.pause');

controle.onclick = function(){
	if(controle.className == 'pause'){
		clearInterval(timer);
		controle.className= 'play';
	}else{
		timer = setInterval(trocaBanner, 4000);
		controle.className = 'pause';
	}
	
	return false;
};
