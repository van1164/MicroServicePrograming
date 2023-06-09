<script>
	import Router from "svelte-spa-router";
	import Home from "./Component/Home/Home.svelte";
	import Show from "./Component/SHOW/show.svelte";
	import Write from "./Component/SHOW/write.svelte";
	
	const routes = {
		'/' : Home,
		'/show' : Show,
		'/write' : Write
	}

</script>

<main>
	<div style="font-size: xx-large">마이크로서비스프로그래밍 Assignment3</div>
	<Router {routes}/>
</main>
