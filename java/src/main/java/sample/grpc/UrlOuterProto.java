// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: url_ticker.proto

package sample.grpc;

public final class UrlOuterProto {
  private UrlOuterProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_UrlRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_UrlRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_LinkTitlesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_LinkTitlesResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020url_ticker.proto\"\036\n\nUrlRequest\022\020\n\010user" +
      "name\030\001 \001(\t\"2\n\022LinkTitlesResponse\022\r\n\005titl" +
      "e\030\001 \001(\t\022\r\n\005topic\030\002 \001(\t2C\n\tUrlTicker\0226\n\014S" +
      "treamTitles\022\013.UrlRequest\032\023.LinkTitlesRes" +
      "ponse\"\000(\0010\001B\"\n\013sample.grpcB\rUrlOuterProt" +
      "oP\001Z\002pbb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_UrlRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_UrlRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_UrlRequest_descriptor,
        new java.lang.String[] { "Username", });
    internal_static_LinkTitlesResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_LinkTitlesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_LinkTitlesResponse_descriptor,
        new java.lang.String[] { "Title", "Topic", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
