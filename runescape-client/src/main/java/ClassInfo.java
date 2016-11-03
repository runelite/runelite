import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("f")
   public int[] field3170;
   @ObfuscatedName("m")
   @Export("args")
   public byte[][][] args;
   @ObfuscatedName("c")
   public int[] field3172;
   @ObfuscatedName("v")
   public int[] field3173;
   @ObfuscatedName("j")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 376069195
   )
   public int field3176;
   @ObfuscatedName("y")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -473433963
   )
   public int field3178;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lclass50;",
      garbageValue = "1429654589"
   )
   public static class50 method3965(int var0) {
      class50 var1 = (class50)class50.field1102.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class50.field1104.method3305(14, var0);
         var1 = new class50();
         if(var2 != null) {
            var1.method1038(new Buffer(var2));
         }

         class50.field1102.put(var1, (long)var0);
         return var1;
      }
   }
}
