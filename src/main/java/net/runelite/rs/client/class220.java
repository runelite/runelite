package net.runelite.rs.client;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hf")
public class class220 {
   @ObfuscatedName("j")
   public final List field3170;
   @ObfuscatedName("a")
   public static Comparator field3171;
   @ObfuscatedName("l")
   public static Comparator field3172 = new class217();
   @ObfuscatedName("i")
   public static Comparator field3173;
   @ObfuscatedName("f")
   public static Comparator field3174;

   @ObfuscatedName("j")
   public void method3945(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field3170, var1);
      } else {
         Collections.sort(this.field3170, Collections.reverseOrder(var1));
      }

   }

   static {
      new class218();
      field3171 = new class216();
      field3173 = new class212();
      field3174 = new class215();
   }

   public class220(class118 var1, boolean var2) {
      int var3 = var1.method2455();
      boolean var4 = var1.method2453() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.method2455();
      this.field3170 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field3170.add(new class213(var1, var5, var3));
      }

   }
}
