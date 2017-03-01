import java.awt.Component;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("df")
public abstract class class112 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-684605091"
   )
   public abstract void vmethod2172(Component var1);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "0"
   )
   public abstract void vmethod2174(Component var1);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-237742120"
   )
   static final void method2179() {
      if(FaceNormal.field1570 != null) {
         FaceNormal.field1570.method1123();
      }

      if(class36.field772 != null) {
         class36.field772.method1123();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "-1850715236"
   )
   public static Object method2183(byte[] var0, boolean var1) {
      if(null == var0) {
         return null;
      } else {
         if(var0.length > 136 && !class156.field2111) {
            try {
               class151 var2 = new class151();
               var2.vmethod3112(var0);
               return var2;
            } catch (Throwable var3) {
               class156.field2111 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "192444946"
   )
   static final String method2184(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-78"
   )
   public abstract int vmethod2185();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1002898716"
   )
   public static void method2186(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class225.field3233 = var1.readUnsignedShort();
      class225.field3236 = new int[class225.field3233];
      class145.field2013 = new int[class225.field3233];
      class186.field2775 = new int[class225.field3233];
      class225.field3235 = new int[class225.field3233];
      Ignore.field211 = new byte[class225.field3233][];
      var1.offset = var0.length - 7 - class225.field3233 * 8;
      class225.field3234 = var1.readUnsignedShort();
      class0.field2 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class225.field3233; ++var3) {
         class225.field3236[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3233; ++var3) {
         class145.field2013[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3233; ++var3) {
         class186.field2775[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class225.field3233; ++var3) {
         class225.field3235[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class225.field3233 * 8 - 3 * (var2 - 1);
      class225.field3237 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class225.field3237[var3] = var1.read24BitInt();
         if(class225.field3237[var3] == 0) {
            class225.field3237[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class225.field3233; ++var3) {
         int var4 = class186.field2775[var3];
         int var5 = class225.field3235[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         Ignore.field211[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var4 * var10 + var9] = var1.readByte();
               }
            }
         }
      }

   }
}
