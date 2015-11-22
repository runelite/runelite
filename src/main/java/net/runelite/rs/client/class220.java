package net.runelite.rs.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hp")
public class class220 {
   @ObfuscatedName("f")
   public static Comparator field3157;
   @ObfuscatedName("l")
   public static Comparator field3158;
   @ObfuscatedName("j")
   public final List field3159;
   @ObfuscatedName("m")
   public static Comparator field3160 = new class217();
   @ObfuscatedName("u")
   public static Comparator field3161;

   @ObfuscatedName("j")
   public void method4057(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3159, var1);
      } else {
         Collections.sort(this.field3159, Collections.reverseOrder(var1));
      }

   }

   static {
      new class218();
      field3157 = new class216();
      field3158 = new class212();
      field3161 = new class215();
   }

   public class220(class118 var1, boolean var2) {
      int var3 = var1.method2538();
      boolean var4 = var1.method2536() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2538();
      this.field3159 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3159.add(new class213(var1, var5, var3));
      }

   }
}
