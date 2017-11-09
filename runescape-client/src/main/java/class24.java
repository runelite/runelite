import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class24 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lf;"
   )
   public static final class24 field356;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lf;"
   )
   public static final class24 field348;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lf;"
   )
   public static final class24 field349;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 466745417
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "[Lko;"
   )
   static IndexedSprite[] field350;
   @ObfuscatedName("j")
   final String field347;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1043763961
   )
   final int field351;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1788699117
   )
   final int field352;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 636202763
   )
   final int field353;

   static {
      field356 = new class24("SMALL", 2, 0, 4);
      field348 = new class24("MEDIUM", 1, 1, 2);
      field349 = new class24("LARGE", 0, 2, 0);
   }

   class24(String var1, int var2, int var3, int var4) {
      this.field347 = var1;
      this.field351 = var2;
      this.field352 = var3;
      this.field353 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(FB)Z",
      garbageValue = "1"
   )
   boolean method193(float var1) {
      return var1 >= (float)this.field353;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Ljj;",
      garbageValue = "-61"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isSolid) {
            var1.interactType = 0;
            var1.field3505 = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lik;I)V",
      garbageValue = "-2087498006"
   )
   public static void method199(IndexDataBase var0) {
      class12.varbit_ref = var0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SB)V",
      garbageValue = "-84"
   )
   public static void method192(String[] var0, short[] var1) {
      class66.method1154(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Lf;",
      garbageValue = "-1131878698"
   )
   static class24 method195(int var0) {
      class24[] var1 = new class24[]{field356, field348, field349};
      class24[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class24 var4 = var2[var3];
         if(var0 == var4.field352) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
      garbageValue = "2"
   )
   static String method198(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class40.sessionToken != null) {
         var3 = "/p=" + class40.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + class36.field480 + var3 + "/";
   }
}
