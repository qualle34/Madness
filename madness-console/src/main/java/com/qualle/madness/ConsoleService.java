package com.qualle.madness;

import com.qualle.madness.context.Context;
import com.qualle.madness.context.ContextResolver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsoleService {

    public static void run() {
        log.info("Startup");
        Context context = ContextResolver.getInstance();

        char[] word = new char[8];

        word[0] = (char) context.ytterbiumServiceImpl().getAtomicNumber();
        word[1] = (char) context.astatineServiceImpl().getAtomicNumber();
        word[2] = (char) context.osmiumServiceImpl().getAtomicNumber();
        word[3] = (char) context.rheniumServiceImpl().getAtomicNumber();
        word[4] = (char) context.germaniumServiceImpl().getAtomicNumber();
        word[5] = (char) context.actiniumServiceImpl().getAtomicNumber();
        word[6] = (char) context.goldServiceImpl().getAtomicNumber();
        word[7] = (char) context.astatineServiceImpl().getAtomicNumber();

        log.info("Secret word is ready");
        System.out.println("=========================================================");
        System.out.println(String.valueOf(word));
        System.out.println("=========================================================");
    }
}