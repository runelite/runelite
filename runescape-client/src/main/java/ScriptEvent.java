import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("t")
   @Export("objs")
   Object[] objs;
   @ObfuscatedName("q")
   @Export("boolean1")
   boolean boolean1;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -219484955
   )
   int field782;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1092709369
   )
   int field789;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 89189973
   )
   int field784;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   Widget field785;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -182394341
   )
   int field780;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 141229905
   )
   int field781;
   @ObfuscatedName("g")
   @Export("string")
   String string;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1106261651
   )
   int field786;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Liw;"
   )
   class245 field779;

   public ScriptEvent() {
      this.field779 = class245.field2959;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;B)V",
      garbageValue = "53"
   )
   public void method1153(Object[] var1) {
      this.objs = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Liw;I)V",
      garbageValue = "244103375"
   )
   public void method1152(class245 var1) {
      this.field779 = var1;
   }

   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "(Lju;Ljava/lang/String;B)V",
      garbageValue = "-26"
   )
   static void method1158(IndexData var0, String var1) {
      class64 var2 = new class64(var0, var1);
      Client.field1023.add(var2);
   }

   @ObfuscatedName("ka")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/String;",
      garbageValue = "-64"
   )
   static String method1157(String var0) {
      Permission[] var1 = new Permission[]{Permission.field3341, Permission.field3345, Permission.field3344, Permission.field3342, Permission.field3340, Permission.field3343};
      Permission[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Permission var4 = var2[var3];
         if(var4.field3346 != -1 && var0.startsWith(class157.method3168(var4.field3346))) {
            var0 = var0.substring(6 + Integer.toString(var4.field3346).length());
            break;
         }
      }

      return var0;
   }
}
