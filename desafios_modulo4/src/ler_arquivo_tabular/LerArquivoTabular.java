package ler_arquivo_tabular;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LerArquivoTabular {

    public static void main(String[] args) throws IOException {
        System.out.println();

        System.out.println("Lendo da Internet: ");
        new LerArquivoTabular()
                .montarListaPessoasComDadosDeUmArquivoTXT(lerArquivoNaInternet())
                .forEach(System.out::println);

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Lendo de Arquivo Local: ");
        new LerArquivoTabular()
                .montarListaPessoasComDadosDeUmArquivoTXT(lerArquivoNaPasta())
                .forEach(System.out::println);
    }

    private static void montarListaComStream(BufferedReader bufferedReader) throws IOException {
        Path path = Paths.get(System.getProperty("user.dir") + "/desafios_modulo4/src/ler_arquivo_tabular/dados.txt");

        // Tem como fazer Stream em Files.
        Files.lines(path)
                .skip(1)
                .map(linha -> {
                    Pessoa pessoa = new Pessoa();
                    pessoa.nome = linha.substring(0, 34).trim();
                    pessoa.dataNascimento = LocalDate.parse(linha.substring(34, 44));
                    pessoa.cidade = linha.substring(49, 79).trim();
                    pessoa.uf = linha.substring(79, 81).trim();
                    return pessoa;
                }).collect(Collectors.toList());
    }

    /**
     * Vai buscar o arquivo na internet e retornar o stream desse arquivo.
     * Vai retornar os bytes desse arquivo?
     */
    private static BufferedReader lerArquivoNaInternet() throws IOException {
        /*
         * Se a URL vier zuada (sem https): vai dar MalformedURLException.
         * URL certa, mas arquivo não existe lá: vai dar IOException.
         */
        try {
            URL url = new URL("https://s3-sa-east-1.amazonaws.com/lcpi/67fdd982-9281-4bb3-bf89-f7c4b157b8f8.txt");
            return new BufferedReader(new InputStreamReader(url.openStream()));
        } catch (MalformedURLException e) {
            throw new MalformedURLException("URL foi escrita incorretamente: " + Arrays.toString(e.getStackTrace()));
        } catch (IOException e) {
            throw new IOException("Erro I/O ao ler arquivo na internet + " + Arrays.toString(e.getStackTrace()));
        }
    }

    private static BufferedReader lerArquivoNaPasta() throws IOException {
        Path path = Paths.get(System.getProperty("user.dir") + "/desafios_modulo4/src/ler_arquivo_tabular/dados.txt");
        return Files.newBufferedReader(path, StandardCharsets.UTF_8);
    }

    /**
     * Extrair os dados de um arquivoTXT e converter em uma lista.
     * Ler linha e linha e ir convertendo cada linha em um objeto pessoa.
     */
    private List<Pessoa> montarListaPessoasComDadosDeUmArquivoTXT(BufferedReader bufferedReader) throws IOException {
        // BufferedReader não pode ser null.
        Objects.requireNonNull(bufferedReader);
        List<Pessoa> pessoas = new LinkedList<>();

        String line;
        boolean firstLine = true;
        int contadorLinhas = 1; // caso dê algum erro na data nascimento: isso vai dizer qual linha do arquivo.

        while ((line = bufferedReader.readLine()) != null) {
            /*
             * Esse if é só pra não ler a primeira linha.
             * Não quero que leia o título das colunas.
             */
            if (firstLine) {
                firstLine = false;
            } else {
                // Nome da pessoa pode ir da coluna 0 até 30 (pode ter espaços em branco, por isso trim()).
                String nome = line.substring(0, 34).trim();
                String dataNascimento = line.substring(34, 44);
                String cidade = line.substring(49, 79).trim();
                String uf = line.substring(79, 81);

                // Idade da pessoa vai da coluna 34 até 44 (como eu sei disso? fui no arquivoTXT e vi a coluna).
                try {
                    LocalDate dataFormatada = LocalDate.parse(dataNascimento);
                    Pessoa pessoa = new Pessoa(nome, dataFormatada, cidade, uf);
                    pessoas.add(pessoa);
                } catch (IllegalArgumentException e) {
                    System.out.println(
                            "Pessoa: " + nome + " tá com data nascimento inválida para LocalDate." +
                                    "\ndata nascimento informada: " + dataNascimento +
                                    "\nlinha " + contadorLinhas + " do arquivo."
                    );
                }
            }
            contadorLinhas++;
        }
        bufferedReader.close();

        return pessoas;
    }

    static class Pessoa {
        String nome;
        LocalDate dataNascimento;
        String cidade;
        String uf;

        public Pessoa() {
        }

        public Pessoa(String nome, LocalDate dataNascimento, String cidade, String uf) {
            this.nome = nome;
            this.dataNascimento = dataNascimento;
            this.cidade = cidade;
            this.uf = uf;
        }

        @Override
        public String toString() {
            return "Pessoa{" +
                    "nome='" + nome + '\'' +
                    ", dataNascimento=" + dataNascimento +
                    ", cidade='" + cidade + '\'' +
                    ", uf='" + uf + '\'' +
                    '}';
        }
    }

}