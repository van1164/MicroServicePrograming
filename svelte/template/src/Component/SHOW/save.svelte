<script>
	import { querystring } from "svelte-spa-router";
	import {getApi} from '../service'
    import App from "../../App.svelte";
	const options = {
        path: '/show',
        access_token: '',
      }
	const getData = getApi(options)

</script>

<main>

	<h1>Hello {$getData}!</h1>
	<p>Visit the <a href="https://svelte.dev/tutorial">Svelte tutorial</a>안녕</p>
</main>

<style>
	main {
		text-align: center;
		padding: 1em;
		max-width: 240px;
		margin: 0 auto;
	}

	h1 {
		color: #ff3e00;
		text-transform: uppercase;
		font-size: 4em;
		font-weight: 100;
	}

	@media (min-width: 640px) {
		main {
			max-width: none;
		}
	}
</style>
