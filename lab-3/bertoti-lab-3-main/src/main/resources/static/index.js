let editandoId = null;

function uid() {
	return ([1e7]+-1e3+-4e3+-8e3+-1e11)
		.replace(/[018]/g, c => (c ^ crypto.getRandomValues(new Uint8Array(1))[0] & 15 >> c / 4).toString(16));
}

async function listarLivros() {
	const res = await fetch('/livros');
	const dados = await res.json();
	renderizarTabela(dados);
}

function renderizarTabela(livros) {
	const corpo = document.getElementById('tabela-corpo');
	corpo.innerHTML = '';
	livros.forEach(l => {
		const tr = document.createElement('tr');
		const tdTitulo = document.createElement('td');
		tdTitulo.textContent = l.titulo;
		const tdAcoes = document.createElement('td');
		tdAcoes.className = 'acoes';

		const btnEditar = document.createElement('button');
		btnEditar.className = 'btn warn';
		btnEditar.textContent = 'Editar';
		btnEditar.onclick = () => iniciarEdicao(l);

		const btnExcluir = document.createElement('button');
		btnExcluir.className = 'btn danger';
		btnExcluir.textContent = 'Excluir';
		btnExcluir.onclick = () => excluir(l.id);

		tdAcoes.appendChild(btnEditar);
		tdAcoes.appendChild(btnExcluir);

		tr.appendChild(tdTitulo);
		tr.appendChild(tdAcoes);
		corpo.appendChild(tr);
	});
}

async function adicionar() {
	const input = document.getElementById('tituloInput');
	const titulo = input.value.trim();
	if (!titulo) return;
	const novo = { id: uid(), titulo };
	await fetch('/livros', {
		method: 'POST',
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify(novo)
	});
	input.value = '';
	await listarLivros();
}

function iniciarEdicao(livro) {
	const input = document.getElementById('tituloInput');
	input.value = livro.titulo;
	editandoId = livro.id;
	document.getElementById('adicionarBtn').textContent = 'Salvar';
}

async function salvarOuAdicionar() {
	if (!editandoId) {
		return adicionar();
	}
	const input = document.getElementById('tituloInput');
	const titulo = input.value.trim();
	if (!titulo) return;
	await fetch(`/livros/${editandoId}`, {
		method: 'PUT',
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify({ id: editandoId, titulo })
	});
	editandoId = null;
	document.getElementById('adicionarBtn').textContent = 'Adicionar';
	input.value = '';
	await listarLivros();
}

async function excluir(id) {
	await fetch(`/livros/${id}`, { method: 'DELETE' });
	await listarLivros();
}

document.addEventListener('DOMContentLoaded', () => {
	document.getElementById('adicionarBtn').addEventListener('click', salvarOuAdicionar);
	listarLivros();
});