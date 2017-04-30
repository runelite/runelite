import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("ay")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("n")
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("q")
   @Export("combatInfo1")
   CombatInfoList combatInfo1;
   @ObfuscatedName("d")
   static IndexDataBase field753;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-511908119"
   )
   boolean method721() {
      return this.combatInfo1.method2793();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-10"
   )
   void method722(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method2790(); var7 != null; var7 = (CombatInfo1)this.combatInfo1.method2791()) {
         ++var6;
         if(var7.field666 == var1) {
            var7.method597(var1, var2, var3, var4);
            return;
         }

         if(var7.field666 <= var1) {
            var5 = var7;
         }
      }

      if(var5 == null) {
         if(var6 < 4) {
            this.combatInfo1.method2788(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method2789(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method2790().unlink();
         }

      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo1;",
      garbageValue = "-1565850470"
   )
   CombatInfo1 method723(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method2790();
      if(var2 != null && var2.field666 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method2791(); var3 != null && var3.field666 <= var1; var3 = (CombatInfo1)this.combatInfo1.method2791()) {
            var2.unlink();
            var2 = var3;
         }

         if(var2.field665 + var2.field666 + this.combatInfo2.field2850 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)Ljava/lang/Class;",
      garbageValue = "-17321"
   )
   static Class method724(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo1 = new CombatInfoList();
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public static void method731() {
      Object var0 = class185.field2730;
      synchronized(class185.field2730) {
         if(class185.field2729 != 0) {
            class185.field2729 = 1;

            try {
               class185.field2730.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass232;I)I",
      garbageValue = "-537072766"
   )
   static final int method732(class232 var0) {
      if(var0 == null) {
         return 12;
      } else {
         switch(var0.field3275) {
         case 8:
            return 20;
         default:
            return 12;
         }
      }
   }
}
